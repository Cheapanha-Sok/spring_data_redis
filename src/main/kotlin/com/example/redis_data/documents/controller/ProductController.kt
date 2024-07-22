package com.example.redis_data.documents.controller

import com.example.redis_data.documents.domain.Product
import com.example.redis_data.documents.repostitory.ProductRepository
import org.apache.coyote.BadRequestException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/product")
class ProductController {
    @Autowired
    lateinit var productRepository: ProductRepository

    @GetMapping("/list")
    fun listProduct(): List<Product> {
        return productRepository.findAll()
    }
    @PostMapping
    fun addProduct(@RequestBody product: Product): Product {
        return productRepository.save(product)
    }
    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: String): Product? {
        return productRepository.findByIdOrNull(id)
    }
    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: String, @RequestBody newProduct: Product): Product {
        val product = productRepository.findById(id).orElseThrow { BadRequestException("Product not found") }
        product.name = newProduct.name
        product.price = newProduct.price
        product.description = newProduct.description
        return productRepository.save(product)
    }
    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: String) {
        val product = productRepository.findById(id).orElseThrow { BadRequestException("Product not found") }
        productRepository.delete(product)
    }
}