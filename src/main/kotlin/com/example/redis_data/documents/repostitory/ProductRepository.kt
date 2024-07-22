package com.example.redis_data.documents.repostitory

import com.example.redis_data.documents.domain.Product
import com.redis.om.spring.repository.RedisDocumentRepository

interface ProductRepository : RedisDocumentRepository<Product, String> {
    fun findProductByName(productName: String): List<Product>
}