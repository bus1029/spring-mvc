package hello.springmvc.basic.requestmapping

import hello.springmvc.basic.HelloData
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
class MappingController {
  private val logger = LoggerFactory.getLogger(javaClass)

  //  @RequestMapping("/hello-basic")
  @GetMapping("/hello-basic")
  fun helloBasic(): String {
    logger.info("hello-basic")
    return "ok"
  }

  /**
   * PathVariable 사용
   * 변수명이 같으면 생략 가능
   * @PathVariable("userId") String userId -> @PathVariable userId
   * /mapping/userA
   */
  @GetMapping("/mapping/{userId}")
  fun mappingPath(@PathVariable("userId") data: String): String {
    logger.info("mappingPath userId={}", data)
    return "ok"
  }

  @GetMapping("/mapping/users/{userId}/orders/{orderId}")
  fun mappingPath(@PathVariable userId: String, @PathVariable orderId: String): String {
    logger.info("mappingPath userId={}, orderId={}", userId, orderId)
    return "ok"
  }

  @GetMapping("/mapping-header", headers = ["mode=debug"])
  fun mappingHeader(): String {
    logger.info("mappingHeader")
    return "ok"
  }

  @PostMapping("/mapping-consume", consumes = ["application/json"])
  fun mappingConsumes(): String {
    logger.info("mappingConsume: application/json")
    return "ok"
  }

  @PostMapping("/mapping-produce", produces = [MediaType.TEXT_HTML_VALUE])
  fun mappingProduces(): String {
    logger.info("mappingProduces: text/html")
    return "ok"
  }

  @ResponseBody
  @RequestMapping("/model-attribute-v1")
  fun modelAttributeV1(@ModelAttribute helloData: HelloData): String {
    return helloData.toString()
  }

  @ResponseBody
  @RequestMapping("/model-attribute-v2")
  fun modelAttributeV2(helloData: HelloData): String {
    return helloData.toString()
  }
}