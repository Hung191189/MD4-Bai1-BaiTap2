package com.example.md4_bai1_baitap2.controller;

import com.example.md4_bai1_baitap2.model.Dictionary;
import com.example.md4_bai1_baitap2.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DictionaryController {
    @Autowired
    DictionaryService dictionaryService;
    @GetMapping("/homeSearch")
    public ModelAndView homeSearch() {
        return new ModelAndView("homeSearch");
    }



    @GetMapping("/createDictionary")
    public ModelAndView createDictionary() {
        return new ModelAndView("form");
    }

    @PostMapping("/createDictionary")
    public ModelAndView saveDictionary(Dictionary dictionary) {
        dictionaryService.create(dictionary);
        return homeSearch();
    }

    @PostMapping("/result")
    public ModelAndView search(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("result");
        String word = request.getParameter("nameSearch");
        List<Dictionary> dictionaryList = dictionaryService.displayAll();
        for (Dictionary dictionary:dictionaryList){
            if(dictionary.getEnglish().equalsIgnoreCase(word)){
                modelAndView.addObject("result", dictionary);
                return modelAndView;
            }
            }
        modelAndView.addObject("notFound", "khong thay");
        return modelAndView;
    }
}
