package com.example.spring_boot_dars1.Controly;

import com.example.spring_boot_dars1.Entity.Dasturchi;
import com.example.spring_boot_dars1.Repository.DasturchiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DasturchiControly {
    @Autowired
    DasturchiRepository dasturchiRepository;
    @RequestMapping(value = "/o'qish" ,method = RequestMethod.GET)
    public  List<Dasturchi> Uqish(){
        List<Dasturchi> all = dasturchiRepository.findAll();
        return all;

    }
    @RequestMapping(value = "/yozish",method =RequestMethod.POST )
    public  String Yozish(@RequestBody Dasturchi malumotlar){
        boolean b = dasturchiRepository.existsByEmail(malumotlar.getEmail());
        if(b) return "Bunday email mavjud";

        Dasturchi dasturchi1=new Dasturchi();
        dasturchi1.setId(malumotlar.getId());
        dasturchi1.setIsm(malumotlar.getIsm());
        dasturchi1.setFamilya(malumotlar.getFamilya());
        dasturchi1.setEmail(malumotlar.getEmail());
        dasturchi1.setTel_raqam(malumotlar.getTel_raqam());
        dasturchi1.setManzil(malumotlar.getManzil());

        dasturchiRepository.save(dasturchi1);
        return "Malumot joylandi";

    }
    @RequestMapping(value = "/select/{id}",method = RequestMethod.GET)
    public Dasturchi malumotOlish(@PathVariable Integer id){
        boolean b = dasturchiRepository.existsById(id);
        if(!b) return null;
        List<Dasturchi> list=dasturchiRepository.findAll();
        for(Dasturchi d:list){
            if(d.getId().equals(id))
                return d;

        }
        return  null;
    }
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.PUT)
    public String Edit(@PathVariable Integer id,@RequestBody Dasturchi malumotlar1){
        Optional<Dasturchi> optionalDasturchi=dasturchiRepository.findById(id);
        if(!optionalDasturchi.isPresent()) return "Bunday malumot mavjud emas";
        Dasturchi dasturchi=optionalDasturchi.get();

        dasturchi.setIsm(malumotlar1.getIsm());
        dasturchi.setFamilya(malumotlar1.getFamilya());
        dasturchi.setEmail(malumotlar1.getEmail());
        dasturchi.setTel_raqam(malumotlar1.getTel_raqam());
        dasturchi.setManzil(malumotlar1.getManzil());
        dasturchiRepository.save(dasturchi);
        return  "taxrirlandi";
    }

    //id ga nisbatan o'chirish
  @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)


      public  String Delete(@PathVariable Integer id){
      Optional<Dasturchi> optionalDasturchi=dasturchiRepository.findById(id);
      if(!optionalDasturchi.isPresent()) return "Bunday malumot mavjud emas";
      dasturchiRepository.deleteById(id);
      return "Malumot o'chirildi";

  }


}
