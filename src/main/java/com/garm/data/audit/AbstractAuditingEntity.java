package com.garm.data.audit;

import com.garm.data.AbstractPersistence;
import com.garm.data.listener.AuditingEntityListener;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@Audited
@AuditOverride(forClass = AbstractPersistence.class)
public abstract class AbstractAuditingEntity<L extends Serializable> extends AbstractPersistence<L> {

}
