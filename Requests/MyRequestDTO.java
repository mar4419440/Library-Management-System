/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Requests;

/**
 *
 * @author ADMIN
 */
import javax.validation.constraints.NotBlank;
public class MyRequestDTO {
       @NotBlank(message = "Name is required")
    private String name;
}
