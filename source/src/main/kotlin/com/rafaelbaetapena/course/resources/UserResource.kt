package com.rafaelbaetapena.course.resources

import com.rafaelbaetapena.course.entities.User
import com.rafaelbaetapena.course.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/users"])
class UserResource(private val userService: UserService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<User>> {
        val userList: List<User> = userService.findAll();
        return ResponseEntity.ok().body(userList)
    }

    @GetMapping(value = ["/{id}"])
    fun findById(@RequestParam id: Long): ResponseEntity<User> {
        val user: User = userService.findBId(id);
        return ResponseEntity.ok().body(user);
    }
}