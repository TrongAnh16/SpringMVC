package com.codegym.repository;

import com.codegym.model.Customer;
import com.codegym.model.Transfer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TransferRepository implements ITransferRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Transfer> findAll() {
        TypedQuery<Transfer> query = em.createQuery("select t from Transfer t", Transfer.class);
        return query.getResultList();
    }

    @Override
    public Transfer findById(Long id) {
        return null;
    }

    @Override
    public void save(Transfer transfer) {
        if (transfer.getId() != null) {
            em.merge(transfer);
        } else {
            em.persist(transfer);
        }
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Double getProfit() {
        TypedQuery<Double> query = em.createQuery("select SUM(t.feeAmount) from Transfer t", Double.class);
        return query.getResultList().get(0);
    }
}
