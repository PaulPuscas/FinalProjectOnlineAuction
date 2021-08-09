package com.sda.onlineAuction.controller;

import com.sda.onlineAuction.dto.ProductDto;
import com.sda.onlineAuction.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/addItem")
    public String getAddItemPage(Model model) {
        //aici procesez din greu Requestul,la final:
        //getAddItemPage - handler
        //model = parametru
        //dispecerul cauta un handler(vezi video ora 19)
        // System.out.println("helooo");
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto", productDto);
        return "addItem";
    }

    @PostMapping("/addItem")
    public String postAddItemPage(ProductDto productDto) {
        System.out.println("Am primit " + productDto);
        productService.add(productDto);
        return "addItem";

    }

}
