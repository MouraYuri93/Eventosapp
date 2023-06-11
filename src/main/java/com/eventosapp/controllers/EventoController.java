package com.eventosapp.controllers;

import com.eventosapp.models.Convidado;
import com.eventosapp.models.Evento;
import com.eventosapp.repository.ConvidadoRepository;
import com.eventosapp.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository er;

    @Autowired
    private ConvidadoRepository cr;

    // Método para exibir o formulário de cadastro de evento
    @RequestMapping(value="/cadastrarEvento", method=RequestMethod.GET)
    public String form(){
        return "evento/formEvento";
    }

    // Método para lidar com o envio do formulário de cadastro de evento
    @RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
    public String form(@Valid Evento evento, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrarEvento";
        }

        er.save(evento);
        attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso!");
        return "redirect:/cadastrarEvento";
    }

    // Método para exibir a lista de eventos
    @RequestMapping("/eventos")
    public ModelAndView listaEventos(){
        ModelAndView mv = new ModelAndView("listaEventos");
        Iterable<Evento> eventos = er.findAll();
        mv.addObject("eventos", eventos);
        return mv;
    }

    // Método para exibir os detalhes de um evento específico
    @RequestMapping(value="/{codigo}", method=RequestMethod.GET)
    public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo){
        Evento evento = er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("evento/detalhesEvento");
        mv.addObject("evento", evento);

        Iterable<Convidado> convidados = cr.findByEvento(evento);
        mv.addObject("convidados", convidados);

        return mv;
    }

    // Método para deletar um evento específico
    @RequestMapping("/deletarEvento")
    public String deletarEvento(long codigo){
        Evento evento = er.findByCodigo(codigo);
        er.delete(evento);
        return "redirect:/eventos";
    }

    // Método para adicionar um convidado a um evento específico
    @PostMapping("/{codigo}")
    public String detalhesEventoPost(@PathVariable("codigo") long codigo, @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/{codigo}";
        }
        Evento evento = er.findByCodigo(codigo);
        convidado.setEvento(evento);

        Convidado convidadoExistente = cr.findByCpf(convidado.getCpf());
        if (convidadoExistente != null) {
            // O convidado já existe no evento
            attributes.addFlashAttribute("mensagem", "Este convidado já está adicionado!");
        } else {
            // O convidado é novo, podemos salvá-lo
            cr.save(convidado);
            attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso!");
        }

        return "redirect:/{codigo}";
    }

    // Método para deletar um convidado de um evento específico
    @RequestMapping("/deletarConvidado")
    public String deletarConvidado(String cpf){
        Convidado convidado = cr.findByCpf(cpf);
        cr.delete(convidado);

        Evento evento = convidado.getEvento();
        long codigoLong = evento.getCodigo();
        String codigo = "" + codigoLong;
        return "redirect:/" + codigo;
    }

    // Método para exibir o formulário de edição de evento
    @RequestMapping(value="/evento/formEditarEvento/{codigo}", method=RequestMethod.GET)
    public ModelAndView formEditarEvento(@PathVariable("codigo") long codigo){
        Evento evento = er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("evento/formEditarEvento");
        mv.addObject("evento", evento);
        return mv;
    }

    // Método para lidar com o envio do formulário de edição de evento
    @RequestMapping(value="/evento/editarEvento", method=RequestMethod.POST)
    public String editarEvento(@Valid Evento evento, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/evento/formEditarEvento/" + evento.getCodigo();
        }

        er.save(evento);
        attributes.addFlashAttribute("mensagem", "Evento editado com sucesso!");
        return "redirect:/" + evento.getCodigo();
    }
}

