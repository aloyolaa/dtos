package com.aloyolaa.dtos.services;

import com.aloyolaa.dtos.dtos.InvoiceDetailDto;
import com.aloyolaa.dtos.dtos.InvoiceDto;
import com.aloyolaa.dtos.entities.Customer;
import com.aloyolaa.dtos.entities.Invoice;
import com.aloyolaa.dtos.mappers.InvoiceMapper;
import com.aloyolaa.dtos.repositories.CustomerRepository;
import com.aloyolaa.dtos.repositories.InvoiceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final CustomerRepository customerRepository;
    private final InvoiceMapper invoiceMapper;

    @Override
    @Transactional(readOnly = true)
    public List<InvoiceDetailDto> findAll() {
        return invoiceRepository.findAll()
                .stream()
                .map(invoiceMapper::toInvoiceDetailDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public InvoiceDetailDto findById(Long id) {
        return invoiceMapper.toInvoiceDetailDto(invoiceRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    @Transactional
    public InvoiceDetailDto save(InvoiceDto invoiceDto) {
        Invoice invoice = invoiceMapper.toEntity(invoiceDto);
        return invoiceMapper.toInvoiceDetailDto(invoiceRepository.save(invoice));
    }

    @Override
    @Transactional
    public InvoiceDetailDto update(InvoiceDto invoiceDto) {
        if (invoiceDto.id() == null) {
            throw new IllegalArgumentException();
        }
        Invoice invoice = invoiceRepository.findById(invoiceDto.id()).orElseThrow(EntityNotFoundException::new);
        //TODO: Customer update is not required
        Customer customer = customerRepository.findById(invoiceDto.customerId()).orElseThrow(EntityNotFoundException::new);
        invoice.setCustomer(customer);
        Invoice updateInvoice = invoiceMapper.partialUpdate(invoiceDto, invoice);
        return invoiceMapper.toInvoiceDetailDto(invoiceRepository.save(updateInvoice));
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        if (!invoiceRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        invoiceRepository.deleteById(id);
        return true;
    }
}
