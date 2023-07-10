package com.garm.data.rev;


import lombok.Data;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;

@Entity
@RevisionEntity(RevEntityListener.class)
@Data
@Table(name = RevEntity.TABLE_NAME)
public class RevEntity {

    public static final String TABLE_NAME = "REVINFO";

    @Id
    @GeneratedValue
    @RevisionNumber
    @Column(name = "REV")
    private Long id;

    @RevisionTimestamp
    @Column(name = "REVTSTMP")
    private long timeStamp;

    @Column(name = "USERNAME")
    private String username;
}
