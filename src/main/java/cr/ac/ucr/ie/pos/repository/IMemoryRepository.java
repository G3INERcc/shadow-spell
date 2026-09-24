/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.ucr.ie.pos.repository;

import cr.ac.ucr.ie.pos.domain.Memory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Geiner
 */
public interface IMemoryRepository extends JpaRepository<Memory, Integer>{
    
}
