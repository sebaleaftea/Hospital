package com.example.hospital_vm.repository;


import com.example.hospital_vm.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

    //usando JPQL
    @Query("SELECT p FROM paciente p WHERE p.apellidos= :apellido")
    List<Paciente> buscarPorApellido(@Param("apellidos") String apellido);

    //Usando SQL Nativo
    @Query(value = "SELECT ¨FROM Paciente WHERE correo= :correo", nativeQuery= true)
    Paciente buscarPorCorreo(@Param("correo")String correo);


}
