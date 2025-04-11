package com.ecommerce.controller;

import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.UploadFileService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;
    @Autowired
    private UploadFileService upload;

    @GetMapping
    public String show(Model model){
        model.addAttribute("products",productService.findAll());
        return "products/show";
    }

    @GetMapping("/create")
    public String create(){
        return "products/create";
    }

    @PostMapping("/save")
    public String save(Product product, @RequestParam("img") MultipartFile file) throws IOException {
        LOGGER.info("This is the object product{}",product);
        User u = new User(1,"","","","","","","");
        product.setUser(u);
        productService.save(product);

        //image

        if(product.getId() == null){ //when the product is created
            String imageName = upload.saveImage(file);
            product.setImage(imageName);
        } else {
            if(file.isEmpty()){ //when the product is edited but the image isn't
                    Product p = new Product();
                    p = productService.get(product.getId()).get();
                    product.setImage(p.getImage());
            } else{
                String imageName = upload.saveImage(file);
                product.setImage(imageName);
            }
        }

        return "redirect:/products";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Product product = new Product();
        Optional<Product> optionalProduct = productService.get(id);
        product = optionalProduct.get();
        LOGGER.info("Product returned ={}", product);
        model.addAttribute("product",product);
        return "products/edit";
    }
    @PostMapping("/update")
    public String update(Product product){
        productService.update(product);
        return "redirect:/products";
    }
}
