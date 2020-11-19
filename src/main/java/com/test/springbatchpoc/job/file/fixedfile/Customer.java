package com.test.springbatchpoc.job.file.fixedfile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    private String name;

    private String lastname;

    private String age;

    private String email;

}
