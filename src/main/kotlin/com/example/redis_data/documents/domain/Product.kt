package com.example.redis_data.documents.domain

import com.redis.om.spring.annotations.Document
import com.redis.om.spring.annotations.Searchable
import org.springframework.data.annotation.Id

@Document
data class Product(
    @Id var id: String? = null,
    @Searchable var name: String? = null,
    var description: String? = null,
    var price : Double? = null,
)