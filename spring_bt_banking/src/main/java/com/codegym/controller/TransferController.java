package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Transfer;
import com.codegym.service.ICustomerService;
import com.codegym.service.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ITransferService transferService;

    @GetMapping
    public String showHistory(Model model) {
        model.addAttribute("transfer", new Transfer());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("transfers", transferService.findAll());
        double profit = 0;
        model.addAttribute("profit", transferService.getProfit());
        return "/transfer/list";
    }

    @PostMapping("/create")
    public String createTransfer(@Valid @ModelAttribute Transfer transfer, Model model, BindingResult result) {
        Customer sender = customerService.findById(transfer.getSender().getId());
        Customer recipient = customerService.findById(transfer.getRecipient().getId());
        if (sender == null || recipient == null) {
            result.rejectValue("sender", "transfer.sender", "Sender or recipient not found");
        }else if (sender.getId() == recipient.getId()) {
            result.rejectValue("sender", "transfer.sender", "Sender id and recipient is must be different");
        }
        if (result.hasErrors()) {
            model.addAttribute("transfer", transfer);
            addAttrs(model);
            return "/transfer/list";
        }
        double feeAmount = transfer.getAmount() * transfer.getFeeRate() / 100;
        double total = transfer.getAmount() + feeAmount;

        transfer.setFeeAmount(feeAmount);
        transfer.setTotalAmount(total);

        transferService.save(transfer);

        sender.setBalance(sender.getBalance() - total);
        recipient.setBalance(recipient.getBalance() + transfer.getAmount());

        customerService.save(sender);
        customerService.save(recipient);

        addAttrs(model);

        return "/transfer/list";
    }

    private void addAttrs(Model model) {
        model.addAttribute("transfer", new Transfer());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("transfers", transferService.findAll());
        model.addAttribute("profit", transferService.getProfit());
    }
}
