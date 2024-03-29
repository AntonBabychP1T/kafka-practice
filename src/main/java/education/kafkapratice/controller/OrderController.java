package education.kafkapratice.controller;

import education.kafkapratice.kafka.OrderProducer;
import education.kafkapratice.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderProducer orderProducer;

    @PostMapping("/send")
    public String sendMessage(@RequestBody Order order) {
        orderProducer.sendMessage(order);
        return "Order sent succesfully";
    }

}
