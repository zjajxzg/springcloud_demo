package springcloud.service.impl;

import com.springcloud.entities.Payment;
import org.springframework.stereotype.Service;
import springcloud.dao.PaymentDao;
import springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author zhigang.xu
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
