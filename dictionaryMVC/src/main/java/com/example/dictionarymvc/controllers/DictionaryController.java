package com.example.dictionarymvc.controllers;

import com.example.dictionarymvc.models.Dictionary;
import com.example.dictionarymvc.service.DictionaryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DictionaryController {
    private DictionaryServiceImpl dictionaryService = new DictionaryServiceImpl();

    @GetMapping("/search")
    public String search() {
        return "index";
    }

    @PostMapping("/result")
    public String meaning(@RequestParam String keyword, Model model) {
        List<Dictionary> dictionaries = this.dictionaryService.findAll();
        for (int i = 0; i < dictionaries.size(); i++) {
            if (keyword.equalsIgnoreCase(dictionaries.get(i).getEn())) {
                model.addAttribute("word", dictionaries.get(i).getVi());
                model.addAttribute("key", keyword);
                return "mean";
            }
        }
        return "mean";
    }
}
