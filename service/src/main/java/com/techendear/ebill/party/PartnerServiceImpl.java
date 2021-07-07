package com.techendear.ebill.party;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private PartnerRepository partnerRepository;

	@Override
	public Optional<Partner> getPartnerById(Long id) throws Exception {
		return this.partnerRepository.findById(id);
	}

	@Override
	public Optional<Page<Partner>> getAllPartners() throws Exception {
		return Optional.of(this.partnerRepository.findAll(PageRequest.of(1, 10)));
	}

	@Override
	public Optional<Partner> savePartner(Partner partner) throws Exception {
		return Optional.of(this.partnerRepository.save(partner));
	}

	@Override
	public Optional<Partner> updatePartner(Long id, Partner partner) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Partner> patchPartner(Long id, Map<Object, Object> fields) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Long> deletePartnerById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
