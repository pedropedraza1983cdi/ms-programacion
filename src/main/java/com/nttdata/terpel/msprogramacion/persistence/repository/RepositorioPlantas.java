package com.nttdata.terpel.msprogramacion.persistence.repository;

import com.nttdata.terpel.msprogramacion.persistence.entity.Plantas;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

public interface RepositorioPlantas extends DatastoreRepository<Plantas, Long> {

    Plantas findByCodigo(String codigo);
}
