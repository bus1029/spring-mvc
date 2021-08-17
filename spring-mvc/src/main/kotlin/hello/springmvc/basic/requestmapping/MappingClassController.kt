package hello.springmvc.basic.requestmapping

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/mapping/users")
class MappingClassController {
  @GetMapping
  fun user(): String {
    return "get users"
  }

  @PostMapping
  fun addUser(): String {
    return "post user"
  }

  @GetMapping("/{userId}")
  fun findUser(@PathVariable userId: String): String {
    return "get userid $userId"
  }

  @PatchMapping("/{userId}")
  fun updateUser(@PathVariable userId: String): String {
    return "update userId $userId"
  }

  @DeleteMapping("/{userId}")
  fun deleteUser(@PathVariable userId: String): String {
    return "delete userId $userId"
  }
}