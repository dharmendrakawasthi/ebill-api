package com.techendear.ebill.party;

import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;

public interface PartnerService {

	public Optional<Partner> getPartnerById(Long id) throws Exception;;

	public Optional<Page<Partner>> getAllPartners() throws Exception;

	public Optional<Partner> savePartner(Partner partner) throws Exception;

	public Optional<Partner> updatePartner(Long id, Partner partner) throws Exception;

	public Optional<Partner> patchPartner(Long id, Map<Object, Object> fields) throws Exception;

	public Optional<Long> deletePartnerById(Long id) throws Exception;
}
