package chat.controller

import chat.model.Greeting
import chat.model.Message
import chat.model.User
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.util.HtmlUtils


@Controller
class GreetingController {

    @Throws(Exception::class)
    @MessageMapping("/chatMessage")
    @SendTo("/topic/greetings")
    fun greeting(name: User, message: Message): Greeting {
        Thread.sleep(1000)
        return Greeting("${HtmlUtils.htmlEscape(name.name)}: ${HtmlUtils.htmlEscape(message.message)}")
    }
}