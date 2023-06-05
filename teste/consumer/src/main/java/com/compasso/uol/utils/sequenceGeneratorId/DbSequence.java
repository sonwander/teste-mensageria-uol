package com.compasso.uol.utils.sequenceGeneratorId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Wanderson Silva
 * @version 1.0.0
 * @since 2021-05-24
 *
 */

@Document(collection = "db_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DbSequence {
    @Id
    private String  id;
    private int seq;
}