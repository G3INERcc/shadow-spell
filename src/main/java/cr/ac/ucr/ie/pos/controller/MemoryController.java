/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package cr.ac.ucr.ie.pos.controller;

import cr.ac.ucr.ie.pos.domain.Memory;
import cr.ac.ucr.ie.pos.service.IMemoryService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Geiner
 */
@Controller
@RequestMapping("/memorys")
public class MemoryController {

    @Autowired
    private IMemoryService service;
    private static final Path UPLOAD_DIRECTORY = Paths.get("uploads", "users");

    @GetMapping("/delete")
    public String delete(@Validated int memId) {
        service.delete(memId);
        return "redirect:/memorys/index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("memorys", service.getAll());
        return "memorys/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("memory", new Memory());
        return "memorys/create";
    }

    @PostMapping("/save")
    public String save( Memory memory, @RequestParam(value = "memPhoto", required = false) MultipartFile memPhoto, Model model) {
        try {
            if(memPhoto != null && !memPhoto.isEmpty()){
                String path = savePhoto(memPhoto);
                memory.setPhoto(path);
            }
        } catch (Exception e) {
        }
        
        service.save(memory);
        return "redirect:/memorys/index";
    }

    private String savePhoto(MultipartFile userPhoto) throws IOException {
        Files.createDirectories(UPLOAD_DIRECTORY);

        String originalName = userPhoto.getOriginalFilename();
        String extension = "";

        if (originalName != null && originalName.contains(".")) {
            extension = originalName.substring(originalName.lastIndexOf("."));
        }
        String fileName = UUID.randomUUID() + extension;

        Path filePath = UPLOAD_DIRECTORY.resolve(fileName);

        Files.copy(userPhoto.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return "uploads/users/" + fileName;
    }
}
