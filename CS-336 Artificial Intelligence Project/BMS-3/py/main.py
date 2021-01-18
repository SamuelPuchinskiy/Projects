from py.Add_Nodes import Add_Nodes
from py.Add_Heuristics import Add_Heuristics
from py.Graph import Graph
from py.Springfield import Springfield

def main():
    while(True):

        count = True
        while count:

            # Asking user for type of heuristic
            print("\nTraffic (enter 1) \nPopulation (enter 2) \nArea of City (enter 3) \nStraight-Line Distance (enter 4) \nComparison for all heurisrtics (enter 5) \nPlease enter one of the above heuristic value you wish to used.")
            answer = input("\nEnter your response (1, 2, 3, 4 or 5): ")
            if(answer == '1' or answer == '2' or answer == '3' or answer == '4' or answer =='5'):
                count = False
                break
            else:
                print("\nInvalid output, try again.\nSpelling counts! \n")

        Springfield(answer)

        # Asking user to try again
        print("\nWould you wish to see select another heurstic and/or city?")
        value = input("Enter your response (Yes or No): ")

        if(value == 'yes' or value == 'Yes'  or value == 'y' or value == 'Y'):
            print("\n\n ......Reloading...... \n")
        else:
            print("\nThank you! Good Bye!")
            break


if __name__ == '__main__':
    main()
