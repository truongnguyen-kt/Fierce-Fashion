package com.mtlt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class usersEntity {
    @Id
    @Field("_id")
    private String username;

    @Indexed(unique = true)
    private String email;

    private String phone;

    private String filename;

    private String img_path;

    private String address;

    private Boolean gender;
}
