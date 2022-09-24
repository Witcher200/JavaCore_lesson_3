package lessons_1;

    public class Course {
        String result;

        private barrier[] barriers;


        public Course(barrier[] barriers) {
            this.barriers = barriers;
        }

        public void doIt(Team group) {
            System.out.println("Do It");//. Название команды: " + group.getName());
            for (Person person : group.getPeoples()) {
                boolean result = true;
                for (barrier barriers : barriers) {

                    switch (barriers.GetType()) {
                        case JumpUP:
                            result = result & barriers.GetValue() <= person.getCanJumpUp();
                            break;
                        case JumpLen:
                            result = result & barriers.GetValue() <= person.getCanJumpLen();
                            break;
                        case Weight:
                            result = result & barriers.GetValue() <= person.getCanGetWeight();
                            break;
                    }
                    if (result) {
                        System.out.println(person.getName() + " прощел препятствие " + barriers.GetType() + " " + barriers.GetValue());
                    } else {
                        System.out.println(person.getName() + " не прощел препятствие " + barriers.GetType() +" " + barriers.GetValue() );
                        break; //прерываем проверку препятствий, если одно не пройдено
                    }
                }
                if (result) {
                    person.setCourseDone();
                } else {
                           System.out.println(person.getName() + " не прощел полосу");
                         }

                }

            }
        }
