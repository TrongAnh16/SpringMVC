package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

//    @GetMapping("/")
//    public ModelAndView showLoginPage() {
//        ModelAndView modelAndView = new ModelAndView("/customer/index");
//        return modelAndView;
//    }
//    @GetMapping("/home")
//    public ModelAndView showHomePage() {
//        ModelAndView modelAndView = new ModelAndView("/customer/review");
//        return modelAndView;
//    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        if (result.hasErrors()) {
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } else {
            customer.setDeleted(false);
            customerService.save(customer);
            modelAndView.addObject("customer", new Customer());
            modelAndView.addObject("message", "New customer created successfully");
            return modelAndView;
        }
    }

    @GetMapping("/")
    public ModelAndView listCustomers() {
        List<Customer> customers = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("/customer/edit");

        if (result.hasErrors()) {
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } else {
            customer.setDeleted(false);
            customerService.save(customer);
            modelAndView.addObject("customer", new Customer());
            modelAndView.addObject("message", "Customer updated successfully");
            return modelAndView;
        }
    }

    @GetMapping("/delete-customer/{id}")
    public String showDeleteForm(@PathVariable Long id) {

        Customer customer = customerService.findById(id);
        customer.setDeleted(true);
        customerService.remove(customer);
        return "redirect:/";
    }

}
