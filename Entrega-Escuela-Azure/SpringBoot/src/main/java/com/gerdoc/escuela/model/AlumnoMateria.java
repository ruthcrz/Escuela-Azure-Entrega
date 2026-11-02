package com.gerdoc.escuela.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ALUMNO_MATERIA", uniqueConstraints = @UniqueConstraint(name = "UK_ALUMNO_MATERIA", columnNames = {"ALUMNO_ID", "MATERIA_ID"}))
public class AlumnoMateria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "ALUMNO_ID", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Alumno alumno;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "MATERIA_ID", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Materia materia;

    @Column(name = "CALIFICACION", precision = 4, scale = 2)
    private BigDecimal calificacion;
}
