package com.evertix.sessionservice.resource;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class SessionSaveResource {
    @Column(nullable = false, updatable = false)
    private Date start_at;

    @Column(nullable = false, updatable = false)
    private Date end_at;

    @NotNull(message = "Status cannot be null")
    @NotBlank(message = "Status cannot be blank")
    @Size(max = 20)
    private String status;

    @NotNull(message = "Topic cannot be null")
    @NotBlank(message = "Topic cannot be blank")
    @Size(max = 150)
    private String topic;

    @NotNull(message = "Link cannot be null")
    @NotBlank(message = "Link cannot be blank")
    @Size(max = 150)
    private String link;
}
