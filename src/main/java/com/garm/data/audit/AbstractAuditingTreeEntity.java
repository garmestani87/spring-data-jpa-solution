package com.garm.data.audit;


import com.garm.data.AbstractPersistence;
import com.garm.data.AbstractTreePersistence;
import com.garm.data.listener.AuditingEntityListener;
import com.garm.data.listener.TreePathListener;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.AuditOverrides;
import org.hibernate.envers.Audited;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class, TreePathListener.class})
@Audited
@AuditOverrides(value = {
        @AuditOverride(forClass = AbstractTreePersistence.class),
        @AuditOverride(forClass = AbstractPersistence.class)
})
public abstract class AbstractAuditingTreeEntity<L extends Serializable, E extends AbstractTreePersistence<L, E>> extends AbstractTreePersistence<L, E> {

}

