import './sidebar.css'
import axios from 'axios';
function Sidebar() {
    const [checkEmailBreaches, setEmailBreaches] = useEffect('');

    const update = () => {
        axios
            .get(haveibeenpwned.com/api/v3/dataclasses)
            .then((res) => {
                setRandomQuote(res.data);
            });
    };

    useEffect(update, []);

   


    return (
        <>
<button className='button-class'>New Credential</button>
   <button className='button2-class'>Refactor Credential</button>
   <button className='button3-class'>Delete Credential</button>
   <button className='button4-class'>Refresh Status</button>

</>
   





    );


 
}

export default Sidebar;