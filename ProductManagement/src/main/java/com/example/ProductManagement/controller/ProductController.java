package com.example.ProductManagement.controller;

import com.example.ProductManagement.model.Product;
import com.example.ProductManagement.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.PrimitiveIterator;

@Controller
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Product> productList = productService.listAll();
        model.addAttribute("products", productList);
        return "index";
    }

    @RequestMapping("/create-products")
    public String showNewProductForm (Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        log.info("product : {}", product);
        productService.save(product);
        return "redirect:/"; //nospace here
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm (@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = productService.get(id);
        mav.addObject("product", product);

        return mav;
    }

}
