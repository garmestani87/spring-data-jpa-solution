package com.garm.data.listener;


import com.garm.data.audit.AbstractAuditingTreeEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.List;

public class TreePathListener {

    @PrePersist
    @PreUpdate
    public void beforePersist(Object reference) {
        AbstractAuditingTreeEntity entity = (AbstractAuditingTreeEntity) reference;
        entity.setPath((entity.getParent() != null ? entity.getParent().getPath() + "," + entity.getParent().getId() : "0"));
        this.updatePath(entity.getChildren(), entity.getPath(), entity);
    }

    private void updatePath(List<AbstractAuditingTreeEntity> lst, String path, AbstractAuditingTreeEntity parent) {
        lst.forEach(entity -> {
            entity.setPath(path + "," + (entity.getParent() != null ? entity.getParent().getId() : "0"));
            entity.setParent(parent);
            if (entity.getChildren() != null && entity.getChildren().size() != 0)
                updatePath(entity.getChildren(), entity.getPath(), entity);
        });

    }

}
