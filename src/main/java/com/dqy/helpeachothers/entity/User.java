package com.dqy.helpeachothers.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
@ToString
public class User {
    Integer id;
    String username;
    String name;
    String phone;
    String sex;
    String headimg;
    String password;
    Integer role;
    Timestamp registertime;
}
