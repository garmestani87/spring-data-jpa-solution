package com.garm.data.listener;


import com.garm.data.AbstractPersistence;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class AuditingEntityListener {

    /**
     * before insert records
     */
    @PrePersist
    public void touchForCreate(Object target) {
        AbstractPersistence entity = AbstractPersistence.class.cast(target);
        entity.setInsertUserId(1L); // you can use your security helper class to obtain current user id
        entity.setInsertDate(LocalDateTime.now());
    }

    /**
     * before update records
     */
    @PreUpdate
    public void touchForUpdate(Object target) {
        AbstractPersistence entity = AbstractPersistence.class.cast(target);
        entity.setModifyUserId(1L); // you can use your security helper class to obtain current user id
        entity.setModifyDate(LocalDateTime.now());
    }
}