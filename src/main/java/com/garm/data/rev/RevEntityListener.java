package com.garm.data.rev;

import org.hibernate.envers.RevisionListener;

public class RevEntityListener implements RevisionListener {
    @Override
    public void newRevision(Object o) {
        RevEntity revEntity = (RevEntity) o;
        revEntity.setUsername("anonymous");
    }
}
