package com.paramveerprakash.data;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paramveerprakash.internal.Product;
import com.paramveerprakash.internal.ProductRepository;

@Component
public class DataInitializer implements InitializingBean {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
	
	@PostConstruct
    public void postConstruct() {
		for(int i=0;i<10;i++) {
			Product p = new Product();
			p.setSku(String.valueOf(i));
			p.setName("Dummy Product "+i);
			p.setPrice(BigDecimal.valueOf(99.9).add(BigDecimal.ONE));
			productRepository.save(p);
		}
    }

    public void init() {
    }

}
