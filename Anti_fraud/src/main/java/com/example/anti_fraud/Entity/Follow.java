package com.example.anti_fraud.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Your Name
 * @since 2024-04-20
 */
@Getter
@Setter
public class Follow implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer followerId;

    private Integer followedId;


}
