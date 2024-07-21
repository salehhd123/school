package com.example.school.Model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teacher_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer age ;

    private String phoneNumber;

    @OneToOne
    @JsonIgnore
    @MapsId
    @JoinColumn(name = "teacher_Id")
    private Teacher teacher;

}
