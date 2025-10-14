package com.poly.lab6_1.controller;

import com.poly.lab6_1.dao.ProductDAO;
import com.poly.lab6_1.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductDAO dao;

    // Bài 3: Sắp xếp
    @RequestMapping("/product/sort")
    public String sort(Model model, @RequestParam("field") Optional<String> field) {
        String sortField = field.orElse("price");
        Sort sort = Sort.by(Direction.ASC, sortField);

        List<Product> items = dao.findAll(sort);
        model.addAttribute("items", items);
        model.addAttribute("field", sortField.toUpperCase());

        return "product/sort";
    }

    // Bài 4: Phân trang
    @RequestMapping("/product/page")
    public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = dao.findAll(pageable);

        model.addAttribute("page", page);

        return "product/page";
    }
        @RequestMapping("/product/pageAndSort")
        public String paginateAndSort(Model model,
                                      @RequestParam("p") Optional<Integer> p,
                                      @RequestParam("field") Optional<String> field) {

            // mặc định 0
            int pageIndex = p.orElse(0);

            // mặc định price
            String sortField = field.orElse("price");

            // Tạo trang, kích thước, sắp xếp
            Pageable pageable = PageRequest.of(pageIndex, 5, Sort.by(Direction.ASC, sortField));

            Page<Product> page = dao.findAll(pageable);

            model.addAttribute("page", page);
            model.addAttribute("field", sortField.toUpperCase());

            return "product/pageAndSort";

    }
}
