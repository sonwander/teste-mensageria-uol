package com.compasso.uol.utils.sequenceGeneratorId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

/**
 *
 * @author Wanderson Silva
 * @version 1.0.0
 * @since 2021-05-25
 *
 */

@Service
public class SequenceGeneratorId {

    @Autowired
    private MongoOperations mongoOperations;

    public long getSequenceNumber(String sequenceName) {
        Query query = new Query(Criteria.where("id").is(sequenceName));
        Update update = new Update().inc("seq", 1);
        DbSequence counter = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        DbSequence.class);

        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}
