package com.example.redis_data

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableRedisDocumentRepositories(basePackages = ["com.example.redis_data.documents.*"])
class RedisDataApplication

fun main(args: Array<String>) {
	runApplication<RedisDataApplication>(*args)
}
