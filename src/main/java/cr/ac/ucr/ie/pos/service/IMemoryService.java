/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.ucr.ie.pos.service;

import cr.ac.ucr.ie.pos.domain.Memory;
import java.util.List;

/**
 *
 * @author Geiner
 */
public interface IMemoryService {
    void save(Memory m);
    void delete(int id);
    List<Memory> getAll();
    Memory getById(int id);
}
