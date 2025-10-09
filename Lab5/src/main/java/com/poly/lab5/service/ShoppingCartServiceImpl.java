package com.poly.lab5.service;

import com.poly.lab5.DB;
import com.poly.lab5.Item;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    Map<Integer, Item> map = new HashMap<>();

    @Override
    public Item add(Integer id) {
        Item item = map.get(id);
        if (item == null) {
            // Lấy item từ DB và thêm vào giỏ hàng
            Item dbItem = DB.items.get(id);
            if (dbItem != null) {
                Item cartItem = new Item(dbItem.getId(), dbItem.getName(), dbItem.getPrice(), 1);
                map.put(id, cartItem);
                return cartItem;
            }
        } else {
            // Tăng số lượng nếu đã tồn tại
            item.setQty(item.getQty() + 1);
            return item;
        }
        return null;
    }

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    @Override
    public Item update(Integer id, int qty) {
        Item item = map.get(id);
        if (item != null) {
            if (qty <= 0) {
                map.remove(id);
                return null;
            } else {
                item.setQty(qty);
                return item;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<Item> getItems() {
        return map.values();
    }

    @Override
    public int getCount() {
        return map.values().stream()
                .mapToInt(Item::getQty)
                .sum();
    }

    @Override
    public double getAmount() {
        return map.values().stream()
                .mapToDouble(item -> item.getPrice() * item.getQty())
                .sum();
    }
}