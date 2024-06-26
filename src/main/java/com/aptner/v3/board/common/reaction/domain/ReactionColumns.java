package com.aptner.v3.board.common.reaction.domain;

import com.aptner.v3.global.domain.BaseTimeEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Embeddable
@Getter
public class ReactionColumns {
    private long countReactionTypeGood;

    private long countReactionTypeBad;

    public ReactionColumns() {
    }

    public ReactionColumns(long countReactionTypeGood, long countReactionTypeBad) {
        this.countReactionTypeGood = countReactionTypeGood;
        this.countReactionTypeBad = countReactionTypeBad;
    }

    public void blindColumns() {
        this.countReactionTypeGood = 0;
        this.countReactionTypeBad = 0;
    }
}
