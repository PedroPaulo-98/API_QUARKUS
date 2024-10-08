package org.acme.service;

import org.acme.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

import org.acme.dto.ProductDTO;
import org.acme.entity.ProductEntity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped

public class ProductService {

    @Inject
    ProductRepository productRepository;

    public List<ProductDTO> getAllProducts(){
        List<ProductDTO> products = new ArrayList<>();
        productRepository.findAll().stream().forEach(item->{
            products.add(mapProductEntityToDTO(item));
        });

        return products;
    }

    public void createNewProduct(ProductDTO product){
        productRepository.persist(mapProducDTOToEntity(product));
    }

    public void changeProduct(Long id, ProductDTO product){
        ProductEntity productEntity = productRepository.findById(id);

        productEntity.setName(product.getName());
        productEntity.setCategory(product.getCategory());
        productEntity.setModel(product.getModel());
        productEntity.setDescription(product.getDescription());
        productEntity.setPrice(product.getPrice());
        
        productRepository.persist(productEntity);
    }

    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }

    private ProductDTO mapProductEntityToDTO(ProductEntity productEntity){
        ProductDTO product = new ProductDTO();

        product.setName(productEntity.getName());
        product.setDescription(productEntity.getDescription());
        product.setCategory(productEntity.getCategory());
        product.setModel(productEntity.getModel());
        product.setPrice(productEntity.getPrice());

        return product;
    }


    private ProductEntity mapProducDTOToEntity(ProductDTO productDto){
        ProductEntity product = new ProductEntity();

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCategory(productDto.getCategory());
        product.setModel(productDto.getModel());
        product.setPrice(productDto.getPrice());

        return product;
    }



}
