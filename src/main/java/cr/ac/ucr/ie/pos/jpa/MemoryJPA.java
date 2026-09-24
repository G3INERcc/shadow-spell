/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.ie.pos.jpa;

import cr.ac.ucr.ie.pos.domain.Memory;
import cr.ac.ucr.ie.pos.repository.IMemoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cr.ac.ucr.ie.pos.service.IMemoryService;

/**
 *
 * @author Geiner
 */
@Service
public class MemoryJPA implements IMemoryService{

    @Autowired
    private IMemoryRepository repo;
    
    @Override
    public void save(Memory m) {
        repo.save(m);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<Memory> getAll() {
        return repo.findAll();
    }

    @Override
    public Memory getById(int id) {
        return repo.findById(id).get();
    }
    
}
