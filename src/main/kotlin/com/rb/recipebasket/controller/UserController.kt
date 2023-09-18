package com.rb.recipebasket.controller

@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("/users")
class UserController(private val userRepository: UserRepository) {

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>> {
        val users = userRepository.findAll()
        return ResponseEntity.ok(users)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: String): ResponseEntity<User> {
        val user = userRepository.findById(id)
        return user.map { ResponseEntity.ok(it) }
                   .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        val savedUser = userRepository.save(user)
        return ResponseEntity.ok(savedUser)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: String, @RequestBody user: User): ResponseEntity<User> {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build()
        }
        val updatedUser = userRepository.save(user)
        return ResponseEntity.ok(updatedUser)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String): ResponseEntity<Void> {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build()
        }
        userRepository.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}
