package Lab6.controller;

import Lab6.dao.ProductDAO;
import Lab6.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    ProductDAO productDAO;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }
}
